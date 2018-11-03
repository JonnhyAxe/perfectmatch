<template>
  <div class="service" style="
    margin-left: 50px;
    margin-right: 50px;
  ">
  <b-table :items="musics" :fields="fields">
    <template slot="show_details" slot-scope="row">
      <button size="sm" @click.stop="row.toggleDetails" class="mr-2">
       {{ row.detailsShowing ? 'Hide' : 'Show'}} Details
      </button>
    </template>
    <template slot="row-details" slot-scope="row">
      <b-card>
        <b-row class="mb-3">
          <b-col sm="3" class="text-sm-right"><b>Id:</b></b-col>
          <b-col>{{ row.item.id }}</b-col>
        </b-row>
        <b-row class="mb-3">
          <b-col sm="3" class="text-sm-right"><b>Style:</b></b-col>
          <b-col>{{ row.item.style }}</b-col>
        </b-row>
        <b-row class="mb-3">
          <b-table :items="row.item.samples" :fields="sampleFields">

          </b-table>
        </b-row>
        <button size="sm" @click="row.toggleDetails">Hide Details</button>
      </b-card>
    </template>

  </b-table>
  </div>
</template>

<script>
import Vue from 'vue'
import bTable from 'bootstrap-vue/es/components/table/table';
import bButton from 'bootstrap-vue/es/components/button/button';
import axios from 'axios'
Vue.component('b-button', bButton);
Vue.component('b-table', bTable);
Vue.use(axios)


export default {
  name: 'PerfectMatch',
  created () {
    // fetch the data when the view is created and the data is
    // already being observed
    this.getMusics()
  },
  data () {
    return {
      fields: [ 'artist', 'name', 'show_details' ],
      sampleFields: [ 'id', 'timestamp' ],
      errors: [],
      musics: []
    }
  },
  methods: {
    getMusics () {
      axios
      .get('http://localhost:8081//music')
        .then(response => {
          // JSON responses are automatically parsed.
          if(response.data !== undefined){
           this.musics = response.data
          }
          // console.log(response.status)
          // console.log(response.data)
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>
