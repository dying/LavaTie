package com.dabbotorg.lavatie.player.api;

import com.dabbotorg.lavatie.commons.data.Identifiable;
import com.sedmelluq.discord.lavaplayer.filter.PcmFilterFactory;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventListener;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Player implements Identifiable {

    @Getter public long id;
    @Getter public AudioEventAdapter eventAdapter;
    @Getter private AudioPlayer audioPlayer;

    public AudioTrack getPlayingTrack() {
        return audioPlayer.getPlayingTrack();
    }

    public void play(AudioTrack audioTrack) {
        audioPlayer.playTrack(audioTrack);
    }

    public void play(AudioTrack audioTrack, boolean noInterrupt) {
        audioPlayer.startTrack(audioTrack, noInterrupt);
    }

    public void stop() {
        audioPlayer.stopTrack();
    }

    public int getVolume() {
        return audioPlayer.getVolume();
    }

    public void setVolume(int volume) {
        audioPlayer.setVolume(volume);
    }

    public void setFilterFactory(PcmFilterFactory factory) {
        audioPlayer.setFilterFactory(factory);
    }

    public void setFrameBufferDuration(int duration) {
        audioPlayer.setFrameBufferDuration(duration);
    }

    public boolean isPaused() {
        return audioPlayer.isPaused();
    }

    public void setPaused(boolean paused) {
        audioPlayer.setPaused(paused);
    }

    public void addListener(AudioEventListener listener) {
        audioPlayer.addListener(listener);
    }

    public void removeListener(AudioEventListener listener) {
        audioPlayer.removeListener(listener);
    }

}
