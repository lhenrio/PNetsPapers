all: WeakBisim.pdf
diff: WeakBisim-diff.pdf
GIT_LATEXDIFF=${shell if command -v git-latexdiff; then echo git-latexdiff; else echo 'git latexdiff'; fi}
# report.pdf

.PHONY: WeakBisim.pdf
WeakBisim.pdf:
	latexmk --pdf WeakBisim.tex

.PHONY: WeakBisim-diff.pdf
WeakBisim-diff.pdf:
	git-latexdiff --allow-spaces --whole-tree --main WeakBisim.tex -o WeakBisim-diff.pdf Before-revision2-weakbisim-paper
