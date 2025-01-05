import request from "@/api";

//新增用户
//查询用户列表
export function studentLogIn(query){
    
    return request({
        //发送请求
        url:'/studentLogin',
        method:'post',
        data:query
    })
}

export function teacherLogIn(query){
    
    return request({
        //发送请求
        url:'/teacherLogin',
        method:'post',
        data:query
    })
}

export function managerLogIn(query){
    
    return request({
        //发送请求
        url:'/MangerLogin',
        method:'post',
        data:query
    })
}