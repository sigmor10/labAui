FROM nginx:1.23.3

LABEL authors="Jakub Kinder"

ENV API_URL=http://localhost:8080/api

EXPOSE 80

ADD dist/front-end-app/browser /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
