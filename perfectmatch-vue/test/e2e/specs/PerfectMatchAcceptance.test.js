// For authoring Nightwatch tests, see
// http://nightwatchjs.org/guide#usage

module.exports = {
  'default e2e tests': function (browser) {
    // automatically uses dev Server port from /config.index.js
    // default: http://localhost:8080
    // see nightwatch.conf.js
    const devServer = browser.globals.devServerURL

    browser
      .url(devServer)
      .waitForElementVisible('#app', 5000)
      .assert.elementPresent('.table')
      .waitForElementVisible('thead', 5000)
      .assert.elementPresent('thead')
      .assert.containsText('thead tr:nth-child(1) > th:nth-child(1)', 'Artist')
      .assert.containsText('thead tr:nth-child(1) > th:nth-child(2)', 'Name')
      .assert.containsText('thead tr:nth-child(1) > th:nth-child(3)', 'Show Details')
      // body content
      .assert.containsText('tbody tr:nth-child(1) > td:nth-child(1)', 'Latmun')
      .assert.containsText('tbody tr:nth-child(1) > td:nth-child(2)', 'Please Stop (Original Mix)')
      .assert.containsText('tbody tr:nth-child(1) > td:nth-child(3)', 'Show Details')

      .assert.containsText('tbody tr:nth-child(2) > td:nth-child(1)', 'Latmun')
      .assert.containsText('tbody tr:nth-child(2) > td:nth-child(2)', 'def (Original Mix)')
      .assert.containsText('tbody tr:nth-child(2) > td:nth-child(3)', 'Show Details')

      .assert.containsText('tbody tr:nth-child(3) > td:nth-child(1)', 'LatmunXPTO')
      .assert.containsText('tbody tr:nth-child(3) > td:nth-child(2)', 'Please Stop (Original Mix)XPTO')
      .assert.containsText('tbody tr:nth-child(3) > td:nth-child(3)', 'Show Details')

      .end()
  }
}
