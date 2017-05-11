package io.muoncore.workshop.newton

import io.muoncore.newton.EventHandler
import io.muoncore.newton.StreamSubscriptionManager
import io.muoncore.newton.eventsource.muon.EventStreamProcessor
import io.muoncore.newton.query.NewtonView
import io.muoncore.newton.query.RebuildingDatastoreView
import org.springframework.stereotype.Service

@Service
@NewtonView(streams = ["requests"])
class CountRequestsView extends RebuildingDatastoreView {

    int requestMade = 0

    CountRequestsView(StreamSubscriptionManager streamSubscriptionManager, EventStreamProcessor eventStreamProcessor) throws IOException {
        super(streamSubscriptionManager, eventStreamProcessor)
    }

    @EventHandler
    def on(RequestReceived request) {
        println "REQUEST!"
        requestMade++
    }
}