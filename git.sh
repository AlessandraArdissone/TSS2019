#!/bin/bash

git add -A && git commit
git push TSS2019 master

#nella root: git.sh
#dal terminale (ROOT), per memorizzare le credenziali: git config credential.helper store
#dal terminale (ROOT), per eseguire il file BASH: sh ./git.sh
#dal terminale (ROOT), per dare i permessi di "eseguibilità" al file BASH: chmod 755 git.sh
#ora è possibile eseguire il file BASH così: ./git.sh
#chiede le credenziali
#per salvare le credenziali (così non le chiede più): git config credential.helper store
#siccome dopo il "commit" non c'è niente, apre un file temporaneo per scrivere la descrizione del salvataggio
#non so se serve: git config --global --unset credential.helper
#non so se serve: git config --system --unset credential.helper (permesso negato)
#per eliminare il salvataggio delle credenziali (le chiederà di nuovo): git config credential.helper erase
