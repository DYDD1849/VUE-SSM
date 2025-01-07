import request from "@/api";

export function MeGetMessage(query){
    
    return request({
        //发送请求
        url:'/MegetMessage',
        method:'post',
        data:query
    })
}

export function MeSendMessage(query){
    
    return request({
        //发送请求
        url:'/addMessage',
        method:'post',
        data:query
    })
}