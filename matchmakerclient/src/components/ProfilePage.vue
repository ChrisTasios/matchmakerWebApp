<template>
  <v-card p>
    <v-layout>
      <v-navigation-drawer
          class="bg-cyan-darken-4"
          theme="dark"
          permanent
      >
        <v-list color="transparent">
          <v-list-item prepend-icon="mdi-view-dashboard" title="Portal"></v-list-item>
        </v-list>

        <template v-slot:append>
          <div class="pa-2">
            <v-btn block @click="logout">
              Logout
            </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
      <v-container align-center>
        <v-row justify="space-around">
            <v-sheet
                :rounded="rounded"
                class="pa-12"
                color="grey-lighten-3"
            >
              <UsersSkillsList @updateSkill="handleSkillsUpdate"/>
            </v-sheet>

          <v-sheet
              :rounded="rounded"
              class="pa-12"
              color="grey-lighten-3"
          >
            <JobOpenings :skills="userSkills"/>
          </v-sheet>
        </v-row>
      </v-container>
    </v-layout>

  </v-card>
</template>

<script setup>
import {useRouter} from "vue-router";
import UsersSkillsList from "@/views/UsersSkillsList.vue";
import JobOpenings from "@/views/JobOpenings.vue";
import {ref} from "vue";

const router = useRouter();

const userSkills = ref([]);

function handleSkillsUpdate(skills) {
  userSkills.value = skills;
}

function logout() {
  router.push("/");
}
</script>

<style scoped>


</style>