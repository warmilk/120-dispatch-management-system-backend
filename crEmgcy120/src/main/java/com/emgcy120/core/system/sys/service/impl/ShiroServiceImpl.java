package com.emgcy120.core.system.sys.service.impl;

import com.emgcy120.core.system.sys.entity.User120;
import com.emgcy120.core.system.sys.entity.UserToken120;
import com.emgcy120.core.system.sys.mapper.User120Mapper;
import com.emgcy120.core.system.sys.mapper.UserToken120Mapper;
import com.emgcy120.core.system.sys.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl implements IShiroService {
//    @Autowired
//    private MenuMapper sysMenuDao;
    @Autowired
    private User120Mapper sysUser120Dao ;
    @Autowired
    private UserToken120Mapper sysUserToken120Dao ;

//    @Override
//    public Set<String> getUserPermissions(long userId) {
//        List<String> permsList;
//
//        //系统管理员，拥有最高权限
//        if(userId == Constants.SUPER_ADMIN){
//            List<Menu> menuList = sysMenuDao.selectByMap(new HashMap<>());
//            permsList = new ArrayList<>(menuList.size());
//            for(Menu menu : menuList){
//                permsList.add(menu.getPerms());
//            }
//        }else{
//            permsList = sysUserDao.queryAllPerms(userId);
//        }
//        //用户权限列表
//        Set<String> permsSet = new HashSet<>();
//        for(String perms : permsList){
//            if(StringUtils.isBlank(perms)){
//                continue;
//            }
//            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//        }
//        return permsSet;
//    }

    @Override
    public UserToken120 queryByToken(String token) {
    	UserToken120 entity = new UserToken120();
    	entity.setToken(token);
        return sysUserToken120Dao.selectOne(entity);
    }

    @Override
    public User120 queryUser(Long userId) {
        return sysUser120Dao.selectById(userId);
    }
}
