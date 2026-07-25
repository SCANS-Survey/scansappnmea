# SCANS App NMEA
PAMGuard plugin to use GPS NMEA data sent from the SCANS app.


Next release of PAMGuard will include a plugin system for NMEA data sources. As well as the current three
(Serial port, simulated, or UDP) it's now possible to add bespoke NMEA acquisition systems through the
updated plugin system. 

This means that a phone / tablet can now be used in place of a standar GPS. This can run on any 
or all of the Android devices providing buttons, cameras, and voice relay to observers. 

The scanspp can aquire location data and pack it in the form of an NMEA GPRMC string and send to a PC
using the MQTT network, this plugin will pick up those messages and send them into the NMEA system. 
