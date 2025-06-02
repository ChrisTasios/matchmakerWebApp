<template>
  <div>
  <v-card elevation="4" class="pa-4">
    <v-toolbar color="surface">
        <v-tabs
            v-model="tabs"
            color="primary"
            grow
        >
          <v-tab :value="1">Login</v-tab>
          <v-tab :value="2">Register</v-tab>
        </v-tabs>
    </v-toolbar>

    <v-tabs-window v-model="tabs">
      <v-tabs-window-item
          v-for="i in 2"
          :key="i"
          :value="i"
      >
        <v-card v-if="i === 1">
          <LoginForm />
        </v-card>
        <v-card v-else>
          <RegistrationForm />
        </v-card>
      </v-tabs-window-item>
    </v-tabs-window>
  </v-card>
  </div>
</template>
<script setup>
import { ref } from 'vue'
import LoginForm from "@/views/LoginForm.vue";
import RegistrationForm from "@/views/RegistrationForm.vue";

const tabs = ref(null)
</script>

<style scoped>
.container {
  max-width: 500px;
  margin: 50px auto;
}
</style>