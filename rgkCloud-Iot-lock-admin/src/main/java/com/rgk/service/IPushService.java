package com.rgk.service;

import com.rgk.pojo.ReturnObject;

public interface IPushService {
    
    public ReturnObject push(int type, boolean broadcast, String content);

}
 