sh ./set_env.sh
java -cp  %H2_CLASSPATH% org.h2.tools.RunScript  -user "sa" -url %MY_H2_DB_URL% -script devise-h2.sql
