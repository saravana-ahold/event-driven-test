package com.ahold.commerce.edt.integration

import com.ahold.commerce.edt.service.Service
import com.ahold.commerce.integration.messageProvider.AbstractMessageSubscriber
import org.springframework.beans.factory.annotation.Qualifier
import com.ahold.commerce.edt.message.Reactor
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(value = ["ahold.integration.jms.jndi.subscribe.topic.enabled"], havingValue = "true")
class JMSTopicSubscribe(@Qualifier("um-subscriber-topic") private val jmsSubscribe: AbstractMessageSubscriber,
                        private val service: Service, private val reactor: Reactor
) {
    init {
        jmsSubscribe.messageListener = this.reactor
    }
}
