# Dockerfile.dev — for development
FROM node:20-alpine

WORKDIR /app

# Install deps
COPY package.json package-lock.json ./
RUN npm install

# Copy source (optional — use volumes in compose)
COPY . .

EXPOSE 3000

CMD ["npm", "run", "dev", "--", "--host"]
