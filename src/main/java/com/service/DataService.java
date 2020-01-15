package com.service;

import com.dao.gfdev.gfDataDao;
import com.dao.gffldev.gfflDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author User: LiZhiYong
 * Date: 2019/8/3
 * Time: 9:57
 * Description: No Description
 */
@Service
public class DataService {
    @Autowired
    private gfDataDao gfdataDao;
    @Autowired
    private gfflDataDao gffldataDao;

    public String data(){
        String gfid = gfdataDao.select();
        String gfflid = gffldataDao.select();
        return "gfid="+gfid+"----"+"gfflid="+gfflid;
    }
}
