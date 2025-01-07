import request from "@/api";

export function MeGetMessage(query){
    
    return request({
        //发送请求
        url:'/findSender',
        method:'post',
        data:query
    })
}

export function MeFindNoread(query){
    
    return request({
        //发送请求
        url:'/findNoReadMessage',
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

export function LoadMessage(query){
    
    return request({
        //发送请求
        url:'/findMessage',
        method:'post',
        data:query
    })
}
