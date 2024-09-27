# ublox GSM Mux for Windows

This project implements the **3GPP 27.010 multiplexer protocol** for serial communication, allowing multiple virtual serial ports over a single physical port.

## Usage
options: -p <serport> : Serial port device to connect. Default [COM62]. -f <framsize> : Maximum frame size. Supported range: 5 - 1509. Default [1500] -n <num ports> : Number of virtual serial ports to open/listen for apps, max supported is 7. Default [5] -H : Use this parameter to disable hardware flow control on serial port. Default Flow control [ENABLED] -b <baudrate> : The baud rate to be used for the COM ports. Default [115200]bps -V <verbosity> : Default (Info) [4] CRITICAL 1, ERROR 2, WARNING 3, INFO 4, DEBUG 5. -d : Displays detailed information regarding mux frames (frame dumps) depending on the set log level. Log Level Required = 5 (DEBUG). Default [DISABLED] -N <num re-trans> : Maximum number of retransmissions. Allowed range is 0-5. Default [3] -A <timeout ms> : Acknowledgement timer in units of ten milliseconds. The allowed range is 1-255. Default [253] -T <timeout ms> : Response timer for the multiplexer control channel in units of ten milliseconds. The allowed range is 2-255. Default [254] -W <timeout ms> : Wake up response timer. The allowed range is 0-255. Default [0] -L <log filename> : Specifies the log filename and location to be used. Default [ubx_mux_trace.txt] -h : Show this help message
