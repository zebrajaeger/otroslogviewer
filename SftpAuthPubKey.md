# Introduction #

Hack to authorize user by public key

# Details #
To connect SFTP using public key authorization you have to:
  1. Your key have toPrepare your key, it have to be without paraphrase. Passphrase can be removed by command: `'$ssh-keygen -p -P passphrase -f keyfile'`
  1. In start script set variable "-Dvfs.Identities" with path to your key


