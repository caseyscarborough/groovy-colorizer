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
    light_gray:    37,
    dark_gray:     90,
    light_red:     91,
    light_green:   92,
    light_yellow:  93,
    light_blue:    94,
    light_magenta: 95,
    light_cyan:    96,
    white:         97,

    // Background colors
    _default_:       49,
    _black_:         40,
    _red_:           41,
    _green_:         42,
    _yellow_:        43,
    _blue_:          44,
    _magenta_:       45,
    _cyan_:          46,
    _light_gray_:    47,
    _dark_gray_:     100,
    _light_red_:     101,
    _light_green_:   102,
    _light_yellow_:  103,
    _light_blue_:    104,
    _light_magenta_: 105,
    _light_cyan_:    106,
    _white_:         107
  ]

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