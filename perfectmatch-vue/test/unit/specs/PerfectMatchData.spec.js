import PerfectMatch from '@/components/PerfectMatch'
import { shallow } from 'vue-test-utils'

describe('PerfectMatch.vue', () => {
  let cmp

  beforeEach(() => {
    cmp = shallow(PerfectMatch, {
      data: {
        musics: [
          {
            'id': '5baf59c9f0139422206e6411',
            'artist': 'Latmun',
            'name': 'Please Stop (Original Mix)',
            'style': 'TECH_HOUSE',
            'samples': [
              {
                'id': '5baf59c9f0139422206e640f',
                'name': 'Latmun:Please Stop (Original Mix)',
                'timestamp': 180,
                'mathes': [
                  {
                    'id': '5baf59c9f0139422206e640e',
                    'name': 'Latmun:Please Stop (Original Mix)'
                  }
                ]
              }
            ]
          }
        ]
      }
    })
  })

  it('equals messages to predefined music', () => {
    expect(cmp.vm.musics).toEqual([
      {
        'id': '5baf59c9f0139422206e6411',
        'artist': 'Latmun',
        'name': 'Please Stop (Original Mix)',
        'style': 'TECH_HOUSE',
        'samples': [
          {
            'id': '5baf59c9f0139422206e640f',
            'name': 'Latmun:Please Stop (Original Mix)',
            'timestamp': 180,
            'mathes': [
              {
                'id': '5baf59c9f0139422206e640e',
                'name': 'Latmun:Please Stop (Original Mix)'
              }
            ]
          }
        ]
      }
    ])
  })
})
