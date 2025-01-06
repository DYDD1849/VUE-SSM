import request from "@/api";
export function managerEnterCourse(query){
    
    return request({
        //发送请求
        url:'/findStudentScore',
        method:'post',
        data:query
    })
}

export function managerAltScore(query){
    
    return request({
        //发送请求
        url:'/altScore',
        method:'post',
        data:query
    })
}

export function managerDelScore(query){
    
    return request({
        //发送请求
        url:'/delScore',
        method:'post',
        data:query
    })
}

export function managerAddScore(query){
    
    return request({
        //发送请求
        url:'/addScore',
        method:'post',
        data:query
    })
}