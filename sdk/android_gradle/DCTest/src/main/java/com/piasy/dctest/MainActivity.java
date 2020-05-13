package com.piasy.dctest;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

public class MainActivity extends Activity implements PeerConnection.Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        PeerConnectionFactory.initialize(
                PeerConnectionFactory.InitializationOptions.builder(getApplicationContext())
                        .setEnableInternalTracer(true)
                        .createInitializationOptions());

        PeerConnectionFactory factory = PeerConnectionFactory.builder()
                .createPeerConnectionFactory();

        PeerConnection.RTCConfiguration rtcConfig =
                new PeerConnection.RTCConfiguration(new ArrayList<>());
        // TCP candidates are only useful when connecting to a server that supports ICE-TCP.
        rtcConfig.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        rtcConfig.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rtcConfig.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rtcConfig.continualGatheringPolicy
                = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        // Use ECDSA encryption.
        rtcConfig.keyType = PeerConnection.KeyType.ECDSA;
        // Enable DTLS for normal calls and disable for loopback calls.
        rtcConfig.enableDtlsSrtp = true;
        rtcConfig.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;

        PeerConnection peerConnection = factory.createPeerConnection(rtcConfig, this);
        DataChannel.Init init = new DataChannel.Init();
        init.ordered = true;
        init.negotiated = false;
        init.maxRetransmits = -1;
        init.maxRetransmitTimeMs = -1;
        init.id = 0;
        peerConnection.createDataChannel("test", init);
    }

    @Override
    public void onSignalingChange(final PeerConnection.SignalingState newState) {
    }

    @Override
    public void onIceConnectionChange(final PeerConnection.IceConnectionState newState) {
    }

    @Override
    public void onIceConnectionReceivingChange(final boolean receiving) {
    }

    @Override
    public void onIceGatheringChange(final PeerConnection.IceGatheringState newState) {
    }

    @Override
    public void onIceCandidate(final IceCandidate candidate) {
    }

    @Override
    public void onIceCandidatesRemoved(final IceCandidate[] candidates) {
    }

    @Override
    public void onDataChannel(final DataChannel dataChannel) {
    }

    @Override
    public void onRenegotiationNeeded() {
    }
}
