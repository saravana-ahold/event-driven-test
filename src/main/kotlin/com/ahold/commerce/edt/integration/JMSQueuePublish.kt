package com.ahold.commerce.edt.integration

import com.ahold.commerce.edt.service.Service
import com.ahold.commerce.integration.messageProvider.AbstractMessagePublisher
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(value = ["ahold.integration.jms.jndi.publish.queue.enabled"], havingValue = "true")
class JMSQueuePublish(@Qualifier("um-publisher-queue") private val jmsQueue: AbstractMessagePublisher,
       private val service: Service,
       @Value("\${ahold.integration.jms.jndi.publish.queue.name}")
       private val topicName: String,
       @Value("\${ahold.integration.jms.jndi.publish.queue.destination")
       private val destination: String
) {

    fun publishMessage(payload: Any) {
        service.publishMessage(jmsQueue, topicName, destination, payload)
    }
}
