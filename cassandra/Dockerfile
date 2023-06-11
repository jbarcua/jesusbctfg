FROM cassandra:4.1.0
COPY cassandra_init-entrypoint.sh /
COPY init_keyspace.cql /docker-entrypoint-initdb.d/
RUN chmod +x cassandra_init-entrypoint.sh
EXPOSE 9042
ENTRYPOINT ["/cassandra_init-entrypoint.sh"]

