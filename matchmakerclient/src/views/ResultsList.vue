<template>
  <v-card
      class="mx-auto"
      max-width="1000"
  >
    <v-card-title>
      Company Employee List
    </v-card-title>

    <v-divider></v-divider>

    <v-virtual-scroll
        :items="items"
        height="320"
        item-height="48"
    >
      <template v-slot:default="{ item }">
        <v-list-item
            :subtitle="`Badge #${item}`"
            :title="`Employee Name`"
        >
          <template v-slot:prepend>
            <v-icon class="bg-primary">mdi-account</v-icon>
          </template>

          <template v-slot:append>
            <v-btn
                icon="mdi-delete"
                size="x-small"
                variant="tonal"
            ></v-btn>
          </template>
        </v-list-item>
      </template>
    </v-virtual-scroll>
  </v-card>
</template>
<script setup>
const items = Array.from({ length: 1000 }, (k, v) => v + 1)
</script>