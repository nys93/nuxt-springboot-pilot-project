FROM node:14

# global install & update
# RUN npm i -g npm && npm i -g yarn

# Create app directory
WORKDIR /frontend

RUN yarn install

#RUN yarn build
ENV HOST 0.0.0.0
EXPOSE 3000

# start command
# CMD [ "yarn", "dev" ]
