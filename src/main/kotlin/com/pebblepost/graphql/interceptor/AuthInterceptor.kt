package com.pebblepost.graphql.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthInterceptor: HandlerInterceptorAdapter() {
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        println("intercept http request ....")
        println(request!!.requestURI)
        println(request!!.queryString)

        return super.preHandle(request, response, handler)
    }
}