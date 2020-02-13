package com.seanshubin.condorcet.frontend

import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.span
import kotlin.browser.document
import kotlin.browser.window

fun printHello() {
    window.onload = {
        document.body!!.append.div {
            span {
                +"Hello"
            }
        }
    }
}

fun main() {
    printHello()
}