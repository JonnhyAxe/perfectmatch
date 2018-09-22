<template>
<div id="watch-example">
  <p> Ask a yes/no question:
    <input v-model="question">
  </p>
  <p>{{ answer }}</p>
</div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      question: '',
      answer: 'I cannot give you an answer until you ask a question!'
    }
  },
  watch: {
    // whenever question changes, this function will run
    question: function (newQuestion, oldQuestion) {
      console.log('question')
      this.answer = 'Waiting for you to stop typing...'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
