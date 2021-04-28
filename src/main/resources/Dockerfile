FROM java:latest
WORKDIR /opt
COPY api-1.0-SNAPSHOT.jar ./
RUN echo > ./start.sh
RUN chmod 777 ./start.sh
RUN echo "java  -jar  ./api-1.0-SNAPSHOT.jar &">> start.sh
RUN echo "tail -f /dev/null" >> start.sh #防止docker启动后自动退


RUN ls
EXPOSE 3096
#ENTRYPOINT ["tail","/dev/null"]
