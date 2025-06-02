<template>
  <v-card class="px-6 py-8 " width="350px">
    <v-form
        v-model="form"
        @submit.prevent="onSubmit"
    >
      <v-text-field
          v-model="userLogin.email"
          prepend-inner-icon="mdi-email-outline"
          class="mb-2"
          clearable
          label="Email"
      />

      <v-text-field
          v-model="userLogin.password"
          label="Password"
          :type="visible ? 'text' : 'password'"
          prepend-inner-icon="mdi-lock-outline"
          :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
          @click:append-inner="visible = !visible"
          placeholder="Enter your password"
      />
      <span class="text-red font-italic">{{ errorMessages }}</span>

      <br>

      <v-btn
          block
          color="success"
          :disabled="!form"
          :loading="loading"
          size="large"
          type="submit"
          variant="elevated"
      >
        Sign In
      </v-btn>
    </v-form>
  </v-card>

</template>

<script setup>
import {reactive, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const form = ref(null)

const userLogin = reactive({
  email: '',
  password: '',
})
const errorMessages = ref('')
const loading = ref(false)
const visible = ref(false)
const router = useRouter()

const onSubmit = () => {
  errorMessages.value = ''
  axios.post('/api/users/login', userLogin)
      .then(res => {
        router.push('/profile/'+res.data.id)
      })
      .catch(error => {
        if (error.response.data.message === '' && error.response.status === 401) {
          errorMessages.value = "Username or password is incorrect"
        } else {
          errorMessages.value = error.response.data.message
        }
      })
      .finally(() => {
        loading.value = false
      })

}
</script>

<style scoped>

</style>