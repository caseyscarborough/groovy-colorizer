# Colorizer

This repository is a Groovy library for colorizing terminal output.

## Installation

Download the [JAR file](http://dl.bintray.com/caseyscarborough/groovy-plugins/colorizer.jar) and add it to your classpath, or clone the project and build the JAR yourself:

```bash
$ git clone https://github.com/caseyscarborough/groovy-colorizer
$ cd groovy-colorizer
$ ./gradlew build
```

## Usage

Add colors to your strings using the syntax `[blue]foo [red]bar`. Then colorize them using the [`Colorizer#colorize`](https://github.com/caseyscarborough/groovy-colorizer/blob/master/src/main/groovy/com/caseyscarborough/colorizer/Colorizer.groovy#L71) method. You can change the background color by using an underscore before the color, like so: `[_lightBlue][black]hello`.

```groovy
import com.caseyscarborough.colorizer.Colorizer

def sentence = "[blue]Hello [_yellow][red]world!"
println Colorizer.colorize(sentence)
```

In addition to this, mixin methods have been created on the Groovy String class to allow you to call the color names as methods on a String. To use these methods, you must first call [`Colorizer#initializeMixins()`](https://github.com/caseyscarborough/groovy-colorizer/blob/master/src/main/groovy/com/caseyscarborough/colorizer/Colorizer.groovy#L63).

```groovy
// Add the methods to the String metaclass
Colorizer.initializeMixins()

"Hello, world!".red() // Outputs the string red
"Foo"._darkGray()     // Outputs the string with dark gray background
```

The following are the colors that can be used for text and background coloring:

* default
* black
* red
* green
* yellow
* blue
* magenta
* cyan
* lightGray
* darkGray
* lightRed
* lightGreen
* lightYellow
* lightBlue
* lightMagenta
* lightCyan
* white

## Testing

```bash
$ ./gradlew test
```

## Credits

Inspired by [colorstring](https://github.com/mitchellh/colorstring) for Go.