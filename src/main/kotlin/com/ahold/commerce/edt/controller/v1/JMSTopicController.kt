package com.ahold.commerce.edt.controller.v1

import com.ahold.commerce.edt.integration.JMSTopicPublish
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.*

@RestController
@ConditionalOnProperty(value = ["ahold.integration.jms.jndi.publish.topic.enabled"], havingValue = "true")
class JMSTopicController(
        private val jmsTopicPublish: JMSTopicPublish,
) {
    @RequestMapping(value = ["/api/postEvents/jmsTopic"], method = [RequestMethod.POST])
    fun getMessage(@RequestBody payload: String) {
        jmsTopicPublish.publishMessage(payload)
    }
}
