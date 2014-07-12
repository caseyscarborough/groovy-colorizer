package com.caseyscarborough.colorizer

class ColorizerTest extends GroovyTestCase {

  def nonColorStrings = [
    "[what]foo",
    "[not_a_color]bar",
    "[foo]bar",
    "[bar]foo"
  ]

  def colorStrings = [
    "[blue]foo [red]bar": "\033[34mfoo \033[31mbar\033[0m",
    "[_black_][yellow]bar [cyan]foo [_white_]foo": "\033[40m\033[33mbar \033[36mfoo \033[107mfoo\033[0m",
    "[foo][light_red]bar": "[foo]\033[91mbar\033[0m"
  ]

  void testNonColors() {
    nonColorStrings.each { string ->
      assertEquals Colorizer.colorize(string), string
    }
  }

  void testColors() {
    colorStrings.each { input, output ->
      assertEquals Colorizer.colorize(input), output
    }
  }
}