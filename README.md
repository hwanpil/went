# Went
> It is a baby project of process simulation and a first step to run after Aspen plus. 

[![immature][immature-image]][love-coding]
[![License][licensesvg]][license]

## Introduction

Process simulation is an interdisciplinary domain, which requires basic knowledge of computer science, chemical engineering,
thermodynamics and so on. Thus, It is exciting to do such a side project to help me recap and sharpen the understanding.
Due to the limitation of time and coding ability, this project is updated slowly and only for fun, 
so if you want something suitable for business or academic modelling, Aspen plus is always a better choice:)

## Some design notes
+ Four levels of abstraction from down to top: Chemicals->Fluids->Components->Factory
+ Every component is only responsible for its upstream not for its downstream, i.e., the run method for component
is designed to pull results from upstream and do some calculation, but not to push results to next downstream components.
+ Use topological sorting (dfs) to determine the run order of components for the case of DAG (no loop)

## To-do list
- [x] General idea of abstraction
- [x] Mixing ideal liquid (single phase and pure substance)
- [ ] Mixture support (Introduction of thermodynamic model) ***hard***
- [ ] Chemicals property database building ***hard***
- [ ] Unit operation support e.g., distillation
- [ ] Loop and convergence ***hard***
- [ ] Chemical reaction modelling support
- [ ] Law of conservation of mass and energy
- [ ] Unit test for each module

## Usage
Not finished.

## Hisotry
+ 2020-05-03 init the project and make plans!
+ 2020-05-08 finished the idea of abstraction part!

## License
[![License][licensesvg]][license]

<!-- Markdown link & img dfn's -->
[licensesvg]: https://img.shields.io/badge/license-MIT-brightgreen.svg
[license]: http://www.opensource.org/licenses/MIT
[immature-image]: https://img.shields.io/badge/side%20project-immature-yellow.svg
[love-coding]: https://cshen.netlify.com