package com.caseyscarborough.colorizer

// This class provides colorized output for Groovy scripts.
//
// Strings should be passed into the colorize method using the syntax '[color]' in
// the string at the starting place that the string should be colored.
//
// For example, the string '[red]Hello, [yellow]world!' would return 'Hello, ' in
// red and 'world!' in yellow. Surrounding the colors with underscores will color
// the background of the string in a similar fashion.
//
// Example:
//   
//   def sentence = "[_red_][black]Hey there, [yellow]how are [blue]you?"
//   println Colorizer.colorize(sentence)
//
// Copyright 2014 Casey Scarborough
//
// Inspired by https://github.com/mitchellh/colorstring
//
class Colorizer {

  private static LinkedHashMap colorCodes = [
    // Font colors
    default:       39,
    black:         30,
    red:           31,
    green:         32,
    yellow:        33,
    blue:          34,
    magenta:       35,
    cyan:          36,
    lightGray:     37,
    darkGray:      90,
    lightRed:      91,
    lightGreen:    92,
    lightYellow:   93,
    lightBlue:     94,
    lightMagenta:  95,
    lightCyan:     96,
    white:         97,

    // Background colors
    _default:       49,
    _black:         40,
    _red:           41,
    _green:         42,
    _yellow:        43,
    _blue:          44,
    _magenta:       45,
    _cyan:          46,
    _lightGray:     47,
    _darkGray:     100,
    _lightRed:     101,
    _lightGreen:   102,
    _lightYellow:  103,
    _lightBlue:    104,
    _lightMagenta: 105,
    _lightCyan:    106,
    _white:        107
  ]

  static void initializeMixins() {
    colorCodes.each { color, code ->
      String.metaClass."$color" = { ->
        return "\033[${code}m$delegate\033[0m"
      }
    }
  }

  static String colorize(String s) {
    def matcher = ( s =~ /\[(\w+)\]/ )
    def output  = s
    matcher.each { match ->
      def color = match[1]
      if (colorCodes[color]) {
        output = output.replaceAll("\\[$color\\]", "\033[${colorCodes[color]}m")
      }
    }

    if (output != s) { 
      return "$output\033[0m"
    }
    return s
  }
}