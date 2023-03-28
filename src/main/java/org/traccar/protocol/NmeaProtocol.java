package org.traccar.protocol;

import org.traccar.BaseProtocol;
import org.traccar.PipelineBuilder;
import org.traccar.TrackerServer;
import org.traccar.config.Config;

import javax.inject.Inject;

public class NmeaProtocol extends BaseProtocol {

    @Inject
    public NmeaProtocol(Config config) {
        addServer(new TrackerServer(config, getName(), false) {
            @Override
            protected void addProtocolHandlers(PipelineBuilder pipeline, Config config) {
                pipeline.addLast(new NmeaProtocolDecoder(NmeaProtocol.this));
            }
        });
    }
}
