import request from "@/api";

export function teacherTable(query){
    
    return request({
        //发送请求
        url:'/findAllTeacher',
        method:'get',
        params:query
    })
}

export function UpdateTeacher(query){
    
    return request({
        //发送请求
        url:'/UpdateTeacherInfo',
        method:'post',
        data:query
    })
}
