# GSM0710 Multiplexer Protocol

This project implements the **GSM0710 Multiplexer Protocol** for serial communication, allowing multiple virtual serial ports over a single physical port.

## Usage

```bash
ublox_mux_win32 [options]
Options:
Option	Description	Default Value
-p <serport>	Serial port device to connect.	COM62
-f <framsize>	Maximum frame size (Range: 5-1509).	1500
-n <num ports>	Number of virtual serial ports to open/listen for apps (Max: 7).	5
-H	Disable hardware flow control on serial port.	Enabled
-b <baudrate>	Baud rate for COM ports.	115200 bps
-V <verbosity>	Verbosity level (1: Critical, 2: Error, 3: Warning, 4: Info, 5: Debug).	4
-d	Display detailed mux frame information (requires log level 5 - Debug).	Disabled
-N <num re-trans>	Maximum number of re-transmissions (Range: 0-5).	3
-A <timeout ms>	Acknowledgement timer in 10ms units (Range: 1-255).	253
-T <timeout ms>	Control channel response timer in 10ms units (Range: 2-255).	254
-W <timeout ms>	Wake-up response timer (Range: 0-255).	0
-L <log filename>	Log file location and name.	ubx_mux_trace.txt
-h	Show help message.	
Example:
bash
Copy code
ublox_mux_win32 -p COM28 -b 921600 -V5 -d
Compiling
To compile the project, use CMake to generate the Visual Studio project:

bash
Copy code
cmake CMakeLists.txt
Compiler: MSVC 2019 or higher
C++ Standard: C++17
Naming Convention
Category	Convention	Example
Macros	UPPERCASE_WITH_UNDERSCORES	MY_CUSTOM_MACRO
constexpr	camelCase (prefixed with c)	c_maxValue
const Global Variables	camelCase (prefixed with c)	c_maxRetries
Global Variables	camelCase	globalCounter
Class Names	PascalCase	MyCustomClass
Member Variables	camelCase (prefixed with m_)	m_width, m_name
Struct Names	PascalCase	MyCustomStruct
Struct Members	camelCase	counter
Function Names	camelCase	myFunction
Function Parameters	camelCase	newSize, fileName
Local Variables	camelCase	localCounter, index
Directory Structure
src/: Contains all source files (*.cpp).
include/: Contains all header files (*.h).
license/: All required licenses for Winmux.
release_letter/: Contains the release letter PDF.
License
See the license/ folder for detailed licensing information.
