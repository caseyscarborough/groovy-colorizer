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

Add colors to your strings using the syntax `[blue]foo [red]bar`. Then colorize them using the [`Colorizer#colorize`](https://github.com/caseyscarborough/groovy-colorizer/blob/master/src/main/groovy/com/caseyscarborough/colorizer/Colorizer.groovy#L63) method. You can change the background color by using underscores around the colors, like so: `[_white_][black]hello`.

```groovy
import com.caseyscarborough.colorizer.Colorizer

def sentence = "[blue]Hello [_yellow_][red]world!"
println Colorizer.colorize(sentence)
```

## Testing

```bash
$ ./gradlew test
```

## Credits

Inspired by [colorstring](https://github.com/mitchellh/colorstring) for Go.