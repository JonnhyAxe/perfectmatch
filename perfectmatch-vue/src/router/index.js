import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import PerfectMatch from '@/components/PerfectMatch'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'PerfectMatch',
      component: PerfectMatch
    },
    {
      path: '/rx',
      name: 'rxPerfectMatch',
      component: PerfectMatch
    }
  ]
})
