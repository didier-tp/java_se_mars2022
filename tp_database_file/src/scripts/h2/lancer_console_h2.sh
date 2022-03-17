. ./set_env.sh

# $HOME/bin/java -jar  ${H2_CLASSPATH} -user "sa" -url ${MY_H2_DB_URL}
java -jar  ${H2_CLASSPATH} -user "sa" -url ${MY_H2_DB_URL}


# NB: penser à se deconnecter
#    et options/session actives/arret pour eviter des futurs verrous/blocages
