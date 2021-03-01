package com.ahold.commerce.edt.integration

import com.ahold.commerce.edt.service.Service
import com.ahold.commerce.integration.messageProvider.AbstractMessageSubscriber
import org.springframework.beans.factory.annotation.Qualifier
import com.ahold.commerce.edt.message.Reactor
import org.apache.logging.log4j.kotlin.logger
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(value = ["ahold.integration.jms.jndi.subscribe.queue.enabled"], havingValue = "true")
class JMSQueueSubscribe(@Qualifier("um-subscriber-queue") private val jmsSubscribe: AbstractMessageSubscriber,
                        private val service: Service, private val reactor: Reactor
) {
    init {
        logger().info("Listener initiated")
        jmsSubscribe.messageListener = this.reactor
    }
}