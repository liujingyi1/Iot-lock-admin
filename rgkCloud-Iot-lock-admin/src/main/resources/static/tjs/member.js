var scripts = [ null, "js/jqGrid/jquery.jqGrid.src.js",
		"js/jqGrid/i18n/grid.locale-en.js", 
		"js/jquery-ui.js",
		null ]

function initGrid() {
	$("#grid-table")
			.jqGrid(
					{
						url : 'member/list?jqGridID=JQGrid1',
						datatype : "json",
						height : '100%',
						colNames : ['id','picUrl','园区', '楼栋', '姓名','电话', '性别', '创建日期', '创建人','操作'],
						colModel : [{
									name : 'id',
									index : 'id',
									hidden : true
								},{
									name : 'picUrl',
									hidden : true
								},{
									name : 'villageId',
									edittype : "select",
									formatter : 'select',
									editoptions : {
										value : getVillages()
									},
									editable : false
								}, {
									name : 'buildingId',
									edittype : "select",
									formatter : 'select',
									editoptions : {
										value : getBuildings()
									},
									editable : false
								}, {
									name : 'name',
									editable : false
								}, {
									name : 'phone',
									editable : false,
									editoptions : {
										size : "20",
										maxlength : "30"
									}
								}, {
									name : 'sex',
									edittype : "select",
									formatter : "select",
									editoptions : {
										value : "0:男;1:女"
									},
									editable : false,
								}, {
									name : 'createdDate',
									sorttype : 'date',
									editable : false,
								}, {
									name : 'createdBy',
									editable : false,
								}, {
									name : 'act',
									index : 'act',
									fixed : true,
									sortable : false,
									resize : false,
								}  ],

						rowNum : 15,
						rowList : [ 10, 15, 20, 30 ],
						pager : "#grid-pager",
						multiselect : true,
						gridComplete : actions,
//						loadComplete : function() {
//							var table = this;
//							setTimeout(function() {
//								updatePagerIcons(table);
//							}, 0);
//						},

//						editurl : "member/save",// nothing is saved
						caption : "人员列表"
					});
}

function actions(){
	var ids = $("#grid-table").jqGrid('getDataIDs');
    for ( var i = 0; i < ids.length; i++) {
      var id = ids[i];
      del = "<button class='btn btn-white btn-danger' title='删除' onclick=\"delRow('"+id+"')\" ><li class='ace-icon fa fa-trash-o bigger-130 orange' ></li></button>&nbsp;";
      sff = "<button class='btn btn-white btn-info' title='下发人脸信息' onclick=\"sendFacialFeatures('"+id+"')\" ><li class='ace-icon fa fa-download bigger-130'></li></button>";
      jQuery("#grid-table").jqGrid('setRowData', ids[i], { act : del + sff });
    }
}

function sendFacialFeatures(id){
	var rowData = $("#grid-table").jqGrid('getRowData',id);
	$.ajax({
		url : 'member/facialFeatures',
		async : false,
		data : {'id':id, 'picUrl':rowData.picUrl, 'villageId':rowData.villageId, 'buildingId':rowData.buildingId},
		success : function(data){
			if(data.code != 0){
				alert('下发成功！');
			}else {
				alert('下发失败！');
			}
		}
	});
}

function delRow(id){
	$( "#dialog-confirm" ).removeClass('hide').dialog({
		resizable: false,
		width: '320',
		modal: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; Delete all items",
				"class" : "btn btn-danger btn-minier",
				click: function() {
					delById(id);
					$( this ).dialog( "close" );
				}
			},{
				html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Cancel",
				"class" : "btn btn-minier",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
		]
	});
}

function delById(id){
	$.ajax({
		url : 'member/del',
		data : {'id':id},
		success : function(data){
			$("#grid-table").trigger("reloadGrid");
		}
	});
}



function getBuildingByVillageId(villageId) {
	var str = "";
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
			}
		}
	});
	return str;
}

// 初始化village、building这两个select
function getVillages() {
	var str = "";
	$.ajax({
		url : "village/all",
		async : false,
		success : function(responseResult) {
			var data = responseResult.result;
			if (data) {
				$.each(data, function(i, v) {
					str = str + v.id + ":" + v.alias + ";"
				});
			}
		}
	});
	str = str.substr(0, str.length - 1);
	return str;
}

function getBuildings() {
	var str = "";
	$.ajax({
		url : "building/all",
		async : false,
		success : function(responseResult) {
			var data = responseResult.result;
			if (data) {
				$.each(data, function(i, v) {
					str = str + v.id + ":" + v.alias + ";"
				});
			}
		}
	});
	str = str.substr(0, str.length - 1);
	return str;
}

function beforeDeleteCallback(e) {
	var form = $(e[0]);
	if (form.data('styled')) {
		return false;
	}

	form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner(
			'<div class="widget-header" />')
	style_delete_form(form);

	form.data('styled', true);
}

function navButtons() {
	jQuery("#grid-table").jqGrid(
			'navGrid',
			"#grid-pager",
			{ // navbar options
				edit : false,
				editicon : 'ace-icon fa fa-pencil blue',
				add : false,
				addicon : 'ace-icon fa fa-plus-circle purple',
				del : true,
				delicon : 'ace-icon fa fa-trash-o red',
				search : false,
				searchicon : 'ace-icon fa fa-search orange',
				refresh : true,
				refreshicon : 'ace-icon fa fa-refresh green',
				view : false,
				viewicon : 'ace-icon fa fa-search-plus grey',
			},
			{
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
							.wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			},
			{
				// new record form
				// width: 700,
				url : 'member/save',
				closeAfterAdd : true,
				recreateForm : true,
				viewPagerButtons : false,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
							.wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			},
			{
				// delete record form
				url : 'member/deleteBatch',
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					if (form.data('styled'))
						return false;
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
							.wrapInner('<div class="widget-header" />')
					style_delete_form(form);

					form.data('styled', true);
				},
				onClick : function(e) {

				}
			},
			{
				// search form
				recreateForm : true,
				afterShowSearch : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-title')
							.wrap('<div class="widget-header" />')
					style_search_form(form);
				},
				afterRedraw : function() {
					style_search_filters($(this));
				},
				multipleSearch : true,
			/**
			 * multipleGroup:true, showQuery: true
			 */
			},
			{
				// view record form
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-title')
							.wrap('<div class="widget-header" />')
				}
			})
}

// function aceSwitch(cellvalue, options, cell) {
// setTimeout(function() {
// $(cell).find('input[type=checkbox]')
// .addClass('ace ace-switch ace-switch-5')
// .after('<span class="lbl"></span>');
// },
// 0);
// }
// enable datepicker
// function pickDate(cellvalue, options, cell) {
// setTimeout(function() {
// $(cell).find('input[type=text]')
// .datepicker({
// format : 'yyyy-mm-dd',
// autoclose : true
// });
// }, 0);
// }

function style_edit_form(form) {
	// enable datepicker on "sdate" field and
	// switches for "stock" field
	// form.find('input[name=sdate]').datepicker({
	// format : 'yyyy-mm-dd',
	// autoclose : true
	// })
	//
	// form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5')
	// .after('<span class="lbl"></span>');
	// don't wrap inside a label element, the
	// checkbox value won't be submitted (POST'ed)
	// .addClass('ace ace-switch
	// ace-switch-5').wrap('<label class="inline"
	// />').after('<span class="lbl"></span>');

	// update buttons classes
	var buttons = form.next().find('.EditButton .fm-button');
	buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon,
	// s-icon
	buttons.eq(0).addClass('btn-primary').prepend(
			'<i class="ace-icon fa fa-check"></i>');
	buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

	buttons = form.next().find('.navButton a');
	buttons.find('.ui-icon').hide();
	buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
	buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
}

function style_delete_form(form) {
	var buttons = form.next().find('.EditButton .fm-button');
	buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]')
			.hide();// ui-icon,
	// s-icon
	buttons.eq(0).addClass('btn-danger').prepend(
			'<i class="ace-icon fa fa-trash-o"></i>');
	buttons.eq(1).addClass('btn-default').prepend(
			'<i class="ace-icon fa fa-times"></i>')
}

function style_search_filters(form) {
	form.find('.delete-rule').val('X');
	form.find('.add-rule').addClass('btn btn-xs btn-primary');
	form.find('.add-group').addClass('btn btn-xs btn-success');
	form.find('.delete-group').addClass('btn btn-xs btn-danger');
}
function style_search_form(form) {
	var dialog = form.closest('.ui-jqdialog');
	var buttons = dialog.find('.EditTable')
	buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info')
			.find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
	buttons.find('.EditButton a[id*="_query"]').addClass(
			'btn btn-sm btn-inverse').find('.ui-icon').attr('class',
			'ace-icon fa fa-comment-o');
	buttons.find('.EditButton a[id*="_search"]').addClass(
			'btn btn-sm btn-purple').find('.ui-icon').attr('class',
			'ace-icon fa fa-search');
}

function beforeEditCallback(e) {
	var form = $(e[0]);
	form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner(
			'<div class="widget-header" />')
	style_edit_form(form);
}

// it causes some flicker when reloading or
// navigating grid
// it may be possible to have some custom formatter
// to do this as the grid is being created to
// prevent this
// or go back to default browser checkbox styles for
// the grid

// unlike navButtons icons, action icons in rows
// seem to be hard-coded
// you can change them like this in here if you want

// replace icons with FontAwesome icons like above
function updatePagerIcons(table) {
	var replacement = {
		'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
		'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
		'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
		'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
			.each(function() {
				var icon = $(this);
				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
				if ($class in replacement) {
					icon.attr('class', 'ui-icon ' + replacement[$class]);
				}
			})
}

$('.page-content-area')
		.ace_ajax(
				'loadScripts',
				scripts,
				function() {
					jQuery(function($) {
						var grid_selector = "#grid-table";
						var pager_selector = "#grid-pager";
						// resize to fit page size
						$(window).on(
								'resize.jqGrid',
								function() {
									$(grid_selector).jqGrid('setGridWidth',
											$(".page-content").width());
								})
						// resize on sidebar collapse/expand
						var parent_column = $(grid_selector).closest(
								'[class*="col-"]');
						$(document)
								.on(
										'settings.ace.jqGrid',
										function(ev, event_name, collapsed) {
											if (event_name === 'sidebar_collapsed'
													|| event_name === 'main_container_fixed') {
												// setTimeout is for webkit
												// only to give time for DOM
												// changes and then
												// redraw!!!
												setTimeout(function() {
													$(grid_selector).jqGrid(
															'setGridWidth',
															parent_column
																	.width());
												}, 0);
											}
										})

						initGrid();

						$(window).triggerHandler('resize.jqGrid');// trigger
																	// window
																	// resize to
																	// make the
																	// grid get
																	// the
																	// correct
																	// size

						// enable search/filter toolbar
						// jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
						// jQuery(grid_selector).filterToolbar({});

						// switch element when editing inline

						// navButtons
						navButtons();

						// var selr =
						// jQuery(grid_selector).jqGrid('getGridParam','selrow');

						$(document).one('ajaxloadstart.page', function(e) {
							$(grid_selector).jqGrid('GridUnload');
							$('.ui-jqdialog').remove();
						});
					});
				});