package com.ahold.commerce.edt.controller.v1

import com.ahold.commerce.edt.integration.JMSQueuePublish
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.*

@RestController
@ConditionalOnProperty(value = ["ahold.integration.jms.jndi.publish.queue.enabled"], havingValue = "true")
class JMSQueueController(
        private val jmsQueuePublish: JMSQueuePublish,
) {
    @RequestMapping(value = ["/api/postEvents/jmsQueue"], method = [RequestMethod.POST])
    fun getMessage(@RequestBody payload: String) {
        jmsQueuePublish.publishMessage(payload)
    }
}
