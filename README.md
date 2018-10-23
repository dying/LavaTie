#LavaTie
An alternative to Lavalink that's designed to work.
Standalone HTTP based audio sending node based on Lavaplayer.

Being used in production by dabBot.

A no-bullshit approach to audio nodes. Where Lavalink quickly loses track of its actual scope, LavaTie sticks to what it really needs to do.
Name inspired by Lavalink.
No built-in metrics through Prometheus because that's out of scope.
No built-in statistics because that's out of scope, use our API to collect your own statistics.
No active connection requirements and no surprises, LavaTie takes care of itself like a big boy.


## Features
* Powered by Lavaplayer
* Near minimal memory footprint (Spring comes with overhead of things not trivial to LavaTie. Lavalink isn't honest about "minimal" footprint, it also runs Spring. Write your own thing in Undertow or Rapidoid if you care about saving a bunch of bytes but at that point you should stay away from JVM anyway)
* Twitch / YouTube stream support
* Seeking
* Volume Control
* REST API for resolving lavaplayer tracks (and a whole bunch more)
* Authentication
* Docker images (is that *really* a feature?)
