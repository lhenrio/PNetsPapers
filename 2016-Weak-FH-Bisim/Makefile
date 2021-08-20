all: WeakBisim.pdf WeakBisim-diff.pdf
GIT_LATEXDIFF=${shell if command -v git-latexdiff; then echo git-latexdiff; else echo 'git latexdiff'; fi}
# report.pdf

.PHONY: WeakBisim.pdf
WeakBisim.pdf:
	cd XFIG; make; cd ..
	latexmk --pdf WeakBisim.tex

.PHONY: WeakBisim-diff.pdf
WeakBisim-diff.pdf:
	git-latexdiff ${shell git remote | head -n 1}/weak-bisim-revision1-base --main WeakBisim.tex -o WeakBisim-diff.pdf
