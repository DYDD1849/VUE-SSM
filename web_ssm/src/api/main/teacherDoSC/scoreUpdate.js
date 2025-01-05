import request from "@/api";

export function TeacherAltScore(query){
    
    return request({
        //发送请求
        url:'/altScore',
        method:'post',
        data:query
    })
}

export function TeacherDelScore(query){
    
    return request({
        //发送请求
        url:'/delScore',
        method:'post',
        data:query
    })
}

export function TeacherAddScore(query){
    
    return request({
        //发送请求
        url:'/addScore',
        method:'post',
        data:query
    })
}