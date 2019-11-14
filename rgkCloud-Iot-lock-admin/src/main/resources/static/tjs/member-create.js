var scripts = [null,
				"js/jquery.bootstrap-duallistbox.js",
				"js/jquery.raty.js",
				"js/chosen.jquery.js",
				"js/x-editable/bootstrap-editable.js",
				"js/x-editable/ace-editable.js",
				"js/jquery.gritter.js",
				null]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		 //inline scripts related to this page
		 jQuery(function($){
			//初始化profile
			initprofile();
			//初始化select控件
			
			initVillage();
			$('.chosen-select').chosen({no_results_text: "未找到匹配项",
//										disable_search_threshold: 10   //10个选项以内不现实搜索框
									  }); 
			//园区变更事件
			$("#village").chosen().change(function(){
				var vId = $(this).val();
				$('#building').prop("disabled", false);
				initBuildingByVillageId(vId);
			});
			
			//楼栋变更事件
			$("#building").chosen().change(function(){
				var vId = $(this).val();
				$('#floor').prop("disabled", false);
				initFloorByBuildingId(vId);
			});
			
			//楼层变更事件
			$("#floor").chosen().change(function(){
				var vId = $(this).val();
				$('#room').prop("disabled", false);
				initRoomByFloorId(vId);
			});
			
			$("#idcard").blur(function() {
				var value = $(this).val();
				if(value != null && $.trim(value) != ''){
					checkIdcard(value);
				}
			});
			
			//提交表单
			$("#submit").on("click", function(){
				var name = $('input[name="name"]').val();
				var sex = $('input[name="sex"]:checked').val();
				var age = $('input[name="age"]').val();
				var idCard = $('input[name="idcard"]').val();
				var phone = $('input[name="phone"]').val();
				var memeberType = $('input[name="memeber_type"]:checked').val();
				var vId = $('#village').val();
				var bId = $('#building').val();
				var fId = $('#floor').val();
				var rId = $('#room').val();
				var picUrl = $('#picUrl').val();
				
				if(name == null || $.trim(name)==''){
					alert('名称不能为空');
					return;
				}
				
				if(idCard == null || $.trim(idCard)==''){
					alert('身份证号不能为空');
					return;
				} else {
					if (!isValidateIdcard(idCard)) {
						alert('身份证号不合法');
						return;
					}
				}
				
//				if(vId == null || vId == -1 
//						|| bId == null || bId == -1
//						|| fId == null || fId == -1
//						|| rId == null || rId == -1) {
//					alert('请选择居住地');
//					return;
//				}
				
				if(picUrl == null){
					alert('请上传人脸特征图片');
					return;
				}
				
				$.ajax({
					url : 'member/save',
					type: 'post',
					dataType : 'json',
					data: {'name':name,'sex':sex,'age':age,'idCard':idCard,'phone':phone,'type':memeberType,'picUrl':picUrl, 
						'villageId':vId, 'buildingId':bId, 'floorId':fId, 'roomId':rId},
					success : function(data){
						if(data.code == 1){
							alert("发布成功！");
//							window.location.reload();
						}else{
							alert("发布失败！");
						}
					}
				});
			});
		});
	});

function isValidateIdcard(idcard){
	var result;
	$.ajax({
		url : 'member/idcardIsValidate',
		data: {'ID':idcard},
		async : false,
		success : function(responseResult){
			result = responseResult;
		}
	});
	return result
}

function checkIdcard(idcard) {
	var isValidate = isValidateIdcard(idcard);
	if (!isValidate) {
		$("#idcard_warning").css("visibility","");
		$("#idcard_group").addClass("has-error");
	} else {
		$("#idcard_warning").css("visibility","hidden");
		$("#idcard_group").removeClass("has-error");
	}
}


//初始化village、building这两个select
function initVillage(){
	var str = "<option value='-1'>请选择园区</option>";
	$.ajax({
		url : "village/all",
		async : false,
		success : function(responseResult){
			var data = responseResult.result;
			if(data){
				$.each(data,function(i,v){
					str = str + '<option role="option" value='+v.id+'>'+v.alias+'</option>'
				});
			}
		}
	});
	$('#village').empty();
	$('#village').append(str);
	$('#village').trigger("liszt:updated");
}



function initBuildingByVillageId(villageId) {
	if(villageId != -1){
		var str = "<option value='-1'>请选择楼栋</option>";
		$.ajax({
			url : "building/findByVillage",
			data : {
				"villageId" : villageId
			},
			async : false,
			success : function(responseResult) {
				var data = responseResult.result;
				if (data) {
					$.each(data, function(i, v) {
						str = str + '<option role="option" value='+v.id+'>'+v.alias+'</option>'
					});
					$('#building').empty();
					$('#building').append(str);
					//需要更新，否则无效
					$("#building").trigger("chosen:updated");
				}
			}
		});
	}else{
		$('#building').empty();
		//需要更新，否则无效
		$("#building").trigger("chosen:updated");
	}
}

function initFloorByBuildingId(buildingId) {
	
	if(buildingId != -1){
		var str = "<option value='-1'>请选择楼层</option>";
		$.ajax({
			url : "floor/findByBuilding",
			data : {
				"buildingId" : buildingId
			},
			async : false,
			success : function(responseResult) {
				var data = responseResult.result;
				if (data) {
					$.each(data, function(i, v) {
						str = str + '<option role="option" value='+v.id+'>'+v.name+'</option>'
					});
					$('#floor').empty();
					$('#floor').append(str);
					//需要更新，否则无效
					$("#floor").trigger("chosen:updated");
				}
			}
		});
	}else{
		$('#floor').empty();
		//需要更新，否则无效
		$("#floor").trigger("chosen:updated");
	}
}

function initRoomByFloorId(floorId) {
	if(floorId != -1){
		var str = "<option value='-1'>请选择房间</option>";
		$.ajax({
			url : "room/findByFloor",
			data : {
				"floorId" : floorId
			},
			async : false,
			success : function(responseResult) {
				var data = responseResult.result;
				if (data) {
					$.each(data, function(i, v) {
						str = str + '<option role="option" value='+v.id+'>'+v.alias+'</option>'
					});
					$('#room').empty();
					$('#room').append(str);
					//需要更新，否则无效
					$("#room").trigger("chosen:updated");
				}
			}
		});
	}else{
		$('#room').empty();
		//需要更新，否则无效
		$("#room").trigger("chosen:updated");
	}
}

function initprofile(){
	$.fn.editable.defaults.mode = 'inline';
	$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
	$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'+
								'<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';    


	try {//ie8 throws some harmless exceptions, so let's catch'em

		//first let's add a fake appendChild method for Image element for browsers that have a problem with this
		//because editable plugin calls appendChild, and it causes errors on IE
		try {
			document.createElement('IMG').appendChild(document.createElement('B'));
		} catch(e) {
			Image.prototype.appendChild = function(el){}
		}

		var last_gritter
		$('#avatar').editable({
			type: 'image',
			name: 'avatar',
			value: null,
			image: {
				//specify ace file input plugin's options here
				btn_choose: '点击上传人脸照片',
				droppable: true,// 拖放图片
				maxSize: 110000,//图片最大值

				//and a few extra ones here
				name: 'file',//put the field name here as well, will be used inside the custom plugin
				on_error : function(error_type) {//on_error function will be called when the selected file has a problem
					if(last_gritter){
						$.gritter.remove(last_gritter);
					}
					
					last_gritter = $.gritter.add({
						sticky: false,
					    time: '2000',
					    speed:500,
					});
					
					if(error_type == 1) {//file format error
						last_gritter = $.gritter.add({
							title: 'File is not an image!',
							text: 'Please choose a jpg|gif|png image!',
							class_name: 'gritter-error gritter-center'
						});
					} else if(error_type == 2) {//file size rror
						last_gritter = $.gritter.add({
							title: 'File too big!',
							text: 'Image size should not exceed 100Kb!',
							class_name: 'gritter-error gritter-center'
						});
					}
					else {//other error
						
					}
				},
				on_success : function() {
					$.gritter.removeAll();
				}
			},
			
			url: function(params) {
				// ***UPDATE AVATAR HERE*** //
				var submit_url = 'member/uploadFace';
				var deferred = null;
				var avatar = '#avatar';

				//if value is empty (""), it means no valid files were selected
				//but it may still be submitted by x-editable plugin
				//because "" (empty string) is different from previous non-empty value whatever it was
				//so we return just here to prevent problems
				var value = $(avatar).next().find('input[type=hidden]:eq(0)').val();
				if(!value || value.length == 0) {
					deferred = new $.Deferred
					deferred.resolve();
					return deferred.promise();
				}

				var $form = $(avatar).next().find('.editableform:eq(0)')
				var file_input = $form.find('input[type=file]:eq(0)');
				var pk = $(avatar).attr('data-pk');//primary key to be sent to server

				var ie_timeout = null

				if( "FormData" in window ) {
					var formData_object = new FormData();//create empty FormData object
					
					//serialize our form (which excludes file inputs)
					$.each($form.serializeArray(), function(i, item) {
						//add them one by one to our FormData 
						formData_object.append(item.name, item.value);							
					});
					//and then add files
					$form.find('input[type=file]').each(function(){
						var field_name = $(this).attr('name');
						var files = $(this).data('ace_input_files');
						if(files && files.length > 0) {
							formData_object.append(field_name, files[0]);
						}
					});

					//append primary key to our formData
					formData_object.append('pk', pk);

					deferred = $.ajax({
								url: submit_url,
							   type: 'POST',
						processData: false,//important
						contentType: false,//important
						   dataType: 'json',//server response type
							   data: formData_object
					})
				} else {
					deferred = new $.Deferred

					var temporary_iframe_id = 'temporary-iframe-'+(new Date()).getTime()+'-'+(parseInt(Math.random()*1000));
					var temp_iframe = 
							$('<iframe id="'+temporary_iframe_id+'" name="'+temporary_iframe_id+'" \
							frameborder="0" width="0" height="0" src="about:blank"\
							style="position:absolute; z-index:-1; visibility: hidden;"></iframe>')
							.insertAfter($form);
							
					$form.append('<input type="hidden" name="temporary-iframe-id" value="'+temporary_iframe_id+'" />');
					
					//append primary key (pk) to our form
					$('<input type="hidden" name="pk" />').val(pk).appendTo($form);
					
					temp_iframe.data('deferrer' , deferred);
					//we save the deferred object to the iframe and in our server side response
					//we use "temporary-iframe-id" to access iframe and its deferred object

					$form.attr({
					  action: submit_url,
					  method: 'POST',
					  enctype: 'multipart/form-data',
					  target: temporary_iframe_id //important
					});

					$form.get(0).submit();

					//if we don't receive any response after 30 seconds, declare it as failed!
					ie_timeout = setTimeout(function(){
						ie_timeout = null;
						temp_iframe.attr('src', 'about:blank').remove();
						deferred.reject({'status':'fail', 'message':'Timeout!'});
					} , 30000);
				}
				
				deferred.done(function(response) {//success
							if(response.code == 1){
								$(avatar).get(0).src = response.result;
								$('#picUrl').val(response.result);
//								alert(response.message);
							}
						}).fail(function(response) {//failure
							alert("There was an error");
						}).always(function() {//called on both success and failure
							if(ie_timeout) clearTimeout(ie_timeout)
							ie_timeout = null;	
						});

				return deferred.promise();
				// ***END OF UPDATE AVATAR HERE*** //
			},
				
			success: function(response, newValue) {
				
			}
		})
		
	}catch(e) {}
	
}
