#FIG2EPS_CONV=fig2dev -L eps
FIG2EPS_CONV=./figtex2eps.bash -v

VPATH=./draws

FIG2EPS:= $(patsubst %.fig,%.eps,$(wildcard *.fig))


PNG2EPS:= $(patsubst %.png,%.eps,$(wildcard *.png))

PNG2PDF:= $(patsubst %.png,%.pdf,$(wildcard *.png))
EPS2PDF:= $(patsubst %.eps,%.pdf,$(wildcard *.eps))

all: $(FIG2EPS) $(PNG2EPS)

pdf: $(FIG2EPS) $(PNG2PDF) $(EPS2PDF)


%.eps: %.fig
	echo $(FIG2EPS_CONV) $< $@
	$(FIG2EPS_CONV) $< $@
	echo "rm -f $@" >> .cleanup

%.eps: %.png
	convert $*.png $@ 
	echo "rm -f $@" >> .cleanup

%.pdf: %.eps
#	convert $*.eps $@ 
	epstopdf $*.eps
	echo "rm -f $@" >> .cleanup

%.eps: %.ps
	cp $*.ps $*.eps


clean:
	if [ -f .cleanup ]; then sh .cleanup; rm -rf .cleanup; fi;
	rm -rf *.pstex*
	rm -rf *.dvi
	rm -rf *.log
	rm -rf *.aux
	rm -rf *.tex
	if [ -f figtex2eps-preamble.tex ]; then rm -f figtex2eps-preamble.tex; fi;
