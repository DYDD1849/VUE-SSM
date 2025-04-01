import request from "@/api";

export function studentTable(query){
    
    return request({
        //发送请求
        url:'/findAllStudent',
        method:'get',
        params:query
    })
}

export function UpdateStudent(query){
    
    return request({
        //发送请求
        url:'/UpdateStudentInfo',
        method:'post',
        data:query
    })
}

export function searchStudent(query){
    
    return request({
        //发送请求
        url:'/searchStudent',
        method:'post',
        data:query
    })
}